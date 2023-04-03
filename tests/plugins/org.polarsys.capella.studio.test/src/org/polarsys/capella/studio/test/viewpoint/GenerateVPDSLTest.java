package org.polarsys.capella.studio.test.viewpoint;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.internal.resources.Marker;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.CompilationUnit;
import org.eclipse.jdt.internal.core.SourceType;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.pde.core.plugin.IExtensions;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.wizards.datatransfer.FileSystemStructureProvider;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.junit.BeforeClass;
import org.junit.Test;
import org.polarsys.capella.test.framework.helpers.IResourceHelpers;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.common.adapter.IContractProvider;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.egf.ContractHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.egf.InvokeActivityHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.launcher.manager.GeneratorLuncherManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.services.action.popup.ActionsUtils;

public class GenerateVPDSLTest {

  static String vpdescFileLocation = "model/QualityAssessment.vpdesc";

  static String projectExplorerViewId = "org.eclipse.ui.navigator.ProjectExplorer";
  static String popupMenuExtensionId = "org.eclipse.ui.popupMenus";

  static String stringToBeSearched = "if (eObjectToTest == null) {";

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {

    File testProject = IResourceHelpers.getFileOrFolderInTestPlugin(GenerateVPDSLTest.class, "model/org.polarsys.capella.vp.qualityassessment.vpdsl");
    File testProjectFileLocation = IResourceHelpers.getFileOrFolderInTestPlugin(GenerateVPDSLTest.class, "model/org.polarsys.capella.vp.qualityassessment.vpdsl/.project");

    //Ensure that the welcome page is closed
    IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
    PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);		

    //Load project description from external project and create the project into the workspace
    IProjectDescription description = null;
    try {
      description = ResourcesPlugin.getWorkspace().loadProjectDescription(  new Path(testProjectFileLocation.getCanonicalPath()));
    } catch (FileNotFoundException e) {
      fail("Test project not found in model/org.polarsys.capella.vp.qualityassessment.vpdsl");
    }

    IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(description.getName());
    project.create(description, null);


    IOverwriteQuery overwriteQuery = new IOverwriteQuery() {
      public String queryOverwrite(String file) { return ALL; }
    };
    //Import the content of the external project into the newly created workspace project
    ImportOperation importOperation = new ImportOperation(project.getFullPath(),
        testProject, FileSystemStructureProvider.INSTANCE, overwriteQuery);
    importOperation.setCreateContainerStructure(false);
    importOperation.run(new NullProgressMonitor());

    project.open(null);
  }

  @Test
  public void test() {
    //Ensure that the project has been successfully imported
    IProject myProject = null;
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot(); 
    for( IProject project : root.getProjects() )
    {			
      if(project.getName().equals("org.polarsys.capella.vp.qualityassessment.vpdsl")) {
        myProject = project;
        break;
      }			
    }

    if(myProject == null) {
      fail("Project not found");
    }

    //Find the vpdescFile
    IResource vpdescFile = myProject.findMember(vpdescFileLocation);		
    if (vpdescFile == null) {
      fail("vpdesc file not found");
    }

    //Ensure that the project explorer view is visible
    IWorkbenchPage currentPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    IViewPart view = null;
    try {
      view = currentPage.showView(projectExplorerViewId);
    } catch (PartInitException e) {
      fail("Could not show view "+projectExplorerViewId);
    }

    //Select the vpdesc file
    StructuredSelection selection = new StructuredSelection( new Object[] {vpdescFile});
    view.getSite().getSelectionProvider().setSelection( selection );

    //Disable autobuild
    IWorkspace workspace= ResourcesPlugin.getWorkspace();
    IWorkspaceDescription desc= workspace.getDescription();
    boolean isAutoBuilding= desc.isAutoBuilding();
    if (isAutoBuilding == true) {
      desc.setAutoBuilding(false);
      try {
        workspace.setDescription(desc);
      } catch (CoreException e) {
        fail("Couldn't disable autobuild");
      }
    }

    //Disable decorators
    IDecoratorManager manager = PlatformUI.getWorkbench().getDecoratorManager();
    try {
      manager.setEnabled("org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.desc.ui.vpdesc.decorator", false);
      manager.setEnabled("org.eclipse.mylyn.tasks.ui.decorators.task", false);
      manager.setEnabled("org.eclipse.ui.VirtualResourceDecorator", false);
      manager.setEnabled("org.eclipse.jdt.ui.buildpath.decorator", false);			
      manager.setEnabled("org.eclipse.ui.SymlinkDecorator", false);			
      manager.setEnabled("org.eclipse.ui.LinkedResourceDecorator", false);
      manager.setEnabled("org.eclipse.egit.ui.internal.decorators.GitLightweightDecorator", false);
      manager.setEnabled("org.eclipse.jdt.internal.ui.without.test.code.decorator", false);
      manager.setEnabled("org.eclipse.ui.ContentTypeDecorator", false);
      manager.setEnabled("org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.desc.ui.decorator1", false);

    } catch (CoreException e1) {
      //fail("Could not disable decorators");
      //Shouldn't be a failure if decorators cannot be disabled 
    }

    generateViewpoint(selection);


    String afProjectName = "org.polarsys.capella.vp.qualityassessment.af";
    String modelProjectName = "org.polarsys.capella.vp.qualityassessment.model";
    String modelCDOProjectName = "org.polarsys.capella.vp.qualityassessment.model.cdo";
    String uiProjectName = "org.polarsys.capella.vp.qualityassessment.ui";


    Map<String, IPluginModelBase> collectedWorkspaceProjects = collectWorkspaceProjects();

    //Test that all plugins have been generated

    assertTrue(collectedWorkspaceProjects.containsKey("org.polarsys.capella.vp.qualityassessment"));
    assertTrue(collectedWorkspaceProjects.containsKey(afProjectName));
    assertTrue(collectedWorkspaceProjects.containsKey("org.polarsys.capella.vp.qualityassessment.contextual.explorer"));
    assertTrue(collectedWorkspaceProjects.containsKey("org.polarsys.capella.vp.qualityassessment.fc"));
    assertTrue(collectedWorkspaceProjects.containsKey(modelProjectName));
    assertTrue(collectedWorkspaceProjects.containsKey(modelCDOProjectName));
    assertTrue(collectedWorkspaceProjects.containsKey("org.polarsys.capella.vp.qualityassessment.model.edit"));
    assertTrue(collectedWorkspaceProjects.containsKey("org.polarsys.capella.vp.qualityassessment.rules.analysis"));
    assertTrue(collectedWorkspaceProjects.containsKey("org.polarsys.capella.vp.qualityassessment.rules.computation"));
    assertTrue(collectedWorkspaceProjects.containsKey("org.polarsys.capella.vp.qualityassessment.rules.generation"));
    assertTrue(collectedWorkspaceProjects.containsKey("org.polarsys.capella.vp.qualityassessment.rules.transformation"));
    assertTrue(collectedWorkspaceProjects.containsKey("org.polarsys.capella.vp.qualityassessment.rules.validation"));
    assertTrue(collectedWorkspaceProjects.containsKey(uiProjectName));

    IProject project = null;

    //Test AF plugin 
    IPluginModelBase model = collectedWorkspaceProjects.get(afProjectName);
    if (model == null) fail("Could not find AF plugin");
    IResource underlyingResource = model.getUnderlyingResource();
    project = underlyingResource.getProject();

    IFile vpIFile =  (IFile) project.findMember("model/QualityAssessment.vp");
    if(vpIFile == null || ! vpIFile.exists()) fail("Could not find file in " + afProjectName);

    //Ensure that plugin.xml properly contains a resourcereuse extension , with tags = "vp" 
    IExtensions extensions = model.getExtensions(); 
    EXTENSIONS_LOOP : for(IPluginExtension pluginExtension : extensions.getExtensions()) {
      if(pluginExtension.getPoint().equals("org.polarsys.kitalpha.resourcereuse.resources")){
        IPluginObject[] children = pluginExtension.getChildren();
        for(IPluginObject child : children) {
          String childName = child.getName();
          if(child instanceof IPluginElement && childName.equals("resource")) {
            IPluginElement element = (IPluginElement) child;
            String tagsValue = element.getAttribute("tags").getValue();
            if(!tagsValue.equals("vp")) {
              fail("incorrect extention point: we should have tags='vp'");
            }
            break EXTENSIONS_LOOP;
          }
        }
      }
    }

    //Test model Plugin
    model = collectedWorkspaceProjects.get(modelProjectName);
    if (model == null) fail("Could not find Model plugin");
    underlyingResource = model.getUnderlyingResource();
    project = underlyingResource.getProject();

    IFile factoryClass =  (IFile) project.findMember("src/org/polarsys/capella/vp/qualityassessment/QualityAssessment/impl/QualityAssessmentFactoryImpl.java");
    IJavaElement element = JavaCore.create(factoryClass);
    CompilationUnit compilationUnit = (CompilationUnit) element;

    try {										
      IJavaElement[] children = compilationUnit.getChildren();
      SourceType source = Arrays.stream(children).filter(child -> child instanceof SourceType).map(SourceType.class::cast).findFirst().get();
      //Ensure that implementation contains capella code
      assertTrue(source.getSource().contains("//begin-capella-code") && source.getSource().contains("//end-capella-code"));

      //Ensure that create methods from the factory have a String parameter (capella code)
      IMethod method1 = source.getMethod("createQualityAssessment",new String[]{"String"});
      IMethod method2 = source.getMethod("createQualityMeasure",new String[]{"String"});

      if(method1 == null || method2 == null) {
        fail("Could not find proper methods");
      }					

    } catch (JavaModelException e) {
      fail("Could not find source for Model plugin");
    }


    //Ensure that fields are generated in non-cdo implementation
    IFile qaClass =  (IFile) project.findMember("src/org/polarsys/capella/vp/qualityassessment/QualityAssessment/impl/QualityAssessmentImpl.java");
    element = JavaCore.create(qaClass);
    compilationUnit = (CompilationUnit) element;
    try {
      //      IType mainType  = compilationUnit.getTypes()[0];
      //      ITypeHierarchy typeHierarchy = mainType.newSupertypeHierarchy(new NullProgressMonitor());
      //      IType[] allSuperTypes = typeHierarchy.getAllSuperclasses(mainType);

      IJavaElement[] children = compilationUnit.getChildren();
      SourceType source = Arrays.stream(children).filter(child -> child instanceof SourceType).map(SourceType.class::cast).findFirst().get();
      IField[] fields = source.getFields();
      assertTrue(fields[0].getElementName().equals("basedOn"));
      assertTrue(fields[1].getElementName().equals("context"));
      assertTrue(fields[2].getElementName().equals("measures"));

    } catch (JavaModelException e) {
      fail("Could not find source for Model plugin");
    }


    //Test CDO plugin
    model = collectedWorkspaceProjects.get(modelCDOProjectName);
    if (model == null) fail("Could not find CDO Model plugin");
    underlyingResource = model.getUnderlyingResource();
    project = underlyingResource.getProject();


    //Check that cdo plugin properly overrides the factory
    IFile cdoQaClass =  (IFile) project.findMember("src/org/polarsys/capella/vp/qualityassessment/QualityAssessment/impl/QualityAssessmentImpl.java");
    extensions = model.getExtensions();	
    EXTENSIONS_LOOP : for(IPluginExtension pluginExtension : extensions.getExtensions()) {
      if(pluginExtension.getPoint().equals("org.eclipse.emf.ecore.factory_override")){
        IPluginObject[] children = pluginExtension.getChildren();

        if(children.length == 0)fail("extension point org.eclipse.emf.ecore.factory_override is empty");

        for(IPluginObject child : children) {
          String childName = child.getName();
          if(child instanceof IPluginElement && childName.equals("factory")) {
            IPluginElement factory = (IPluginElement) child;
            String uriValue = factory.getAttribute("uri").getValue();								

            if(!uriValue.equals("http://www.polarsys.org/capella/QualityAssessment")) {
              fail("incorrect extention point, uri should point to QualityAssessment");
            }

            String classValue = factory.getAttribute("class").getValue();

            if(!classValue.equals("org.polarsys.capella.vp.qualityassessment.QualityAssessment.impl.QualityAssessmentFactoryImpl")) {
              fail("incorrect extention point class should point to QualityAssessmentFactoryImpl");
            }
            break EXTENSIONS_LOOP;
          }
        }
        fail("Could not find factory in extension point org.eclipse.emf.ecore.factory_override");
      }
    }

    element = JavaCore.create(cdoQaClass);
    compilationUnit = (CompilationUnit) element;
    try {
      IJavaElement[] children = compilationUnit.getChildren();	

      IType mainType  = compilationUnit.getTypes()[0];
      ITypeHierarchy typeHierarchy = mainType.newSupertypeHierarchy(new NullProgressMonitor());
      IType[] allSUperTypes = typeHierarchy.getAllSuperclasses(mainType);
      SourceType source = Arrays.stream(children).filter(child -> child instanceof SourceType).map(SourceType.class::cast).findFirst().get();
      IField[] fields = source.getFields();

      //Ensure there are no fields
      Stream<IField> streamOfFields = Arrays.stream(fields);					
      assertTrue(streamOfFields.noneMatch(field -> field.getElementName().equals("basedOn")
          || field.getElementName().equals("context") || field.getElementName().equals("measures")));

      //Ensure the getters are using eDynamicGet
      IMethod[] methods = source.getMethods();
      IMethod getBasedOnMethod = Arrays.stream(methods).filter(method -> method.getElementName().contains("getBasedOn")).findFirst().get();
      assertTrue(getBasedOnMethod.getSource().contains("eDynamicGet"));

      IMethod getContextMethod = Arrays.stream(methods).filter(method -> method.getElementName().contains("getContext")).findFirst().get();
      assertTrue(getContextMethod.getSource().contains("eDynamicGet"));

      IMethod getMeasuresMethod = Arrays.stream(methods).filter(method -> method.getElementName().contains("getMeasures")).findFirst().get();
      assertTrue(getMeasuresMethod.getSource().contains("eDynamicGet"));



    } catch (JavaModelException e) {
      fail("Could not find source for CDO Model plugin");
    }
    
    //Test ui Plugin
    model = collectedWorkspaceProjects.get(uiProjectName);
    if (model == null) fail("Could not find UI plugin");
    underlyingResource = model.getUnderlyingResource();
    project = underlyingResource.getProject();

    IFile qaSectionClass =  (IFile) project.findMember("src/org/polarsys/capella/vp/qualityassessment/ui/sections/QualityAssessment_QualityAssessment_QualityAssessment_QualityAssessment_Section.java");
     element = JavaCore.create(qaSectionClass);
     compilationUnit = (CompilationUnit) element;

    try {                   
      IJavaElement[] children = compilationUnit.getChildren();
      SourceType source = Arrays.stream(children).filter(child -> child instanceof SourceType).map(SourceType.class::cast).findFirst().get();

      //Ensure that select method is properly generated
      IMethod[] methods = source.getMethods();
      IMethod selectMethod = Arrays.stream(methods).filter(method -> method.getElementName().contains("select")).findFirst().get();

     
      if(selectMethod == null) {
        fail("Could not find select method");
      }         
      
      assertTrue(selectMethod.getSource().contains("if (eObjectToTest == null) {"));

    } catch (JavaModelException e) {
      fail("Could not find source for UI plugin");
    }


    refreshAndBuildWorkspace();


    //Ensure that workspace is properly built and there are no error markers
    IMarker[] markers = null;
    try {
      markers = workspace.getRoot().findMarkers(IMarker.MARKER, true, IResource.DEPTH_INFINITE);
    } catch (CoreException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    List<Marker> errorMarkers = Arrays.stream(markers)
        .filter(imarker -> imarker instanceof Marker)
        .map(Marker.class::cast)
        //Filter only error markers
        .filter(marker -> {
          try {
            Object attribute = marker.getAttribute(IMarker.SEVERITY);
            if(attribute == null) return false;
            return   (int) attribute == IMarker.SEVERITY_ERROR;
          } catch (CoreException e1) {
            return false;
          }
        })
        .collect(Collectors.toList());

    assertTrue(errorMarkers.isEmpty());


  }

  protected Map<String, IPluginModelBase> collectWorkspaceProjects(){
    Map<String, IPluginModelBase> map = new HashMap<String, IPluginModelBase>();
    for (IPluginModelBase model : PDECore.getDefault().getModelManager().getWorkspaceModels()) {
      IResource underlyingResource = model.getUnderlyingResource();
      IProject project = underlyingResource.getProject();
      String pluginName = project.getName();
      map.put(pluginName, model);
    }
    return map;
  }

  protected void refreshAndBuildWorkspace() {
    IWorkspace workspace= ResourcesPlugin.getWorkspace();
    synchronized(this) {
      Job job = new Job("Refresh And Build") {
        @Override
        public IStatus run(IProgressMonitor monitor) {
          try {
            workspace.getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            workspace.build(IncrementalProjectBuilder.FULL_BUILD, new NullProgressMonitor());
          } catch (CoreException e) {
            e.printStackTrace();
            return Status.CANCEL_STATUS;
          }
          return Status.OK_STATUS;
        }
      };
      job.setUser(true);
      job.schedule(); 
      try {
        job.join();
      } catch (InterruptedException e) {
        fail("Job Interrupted");
      }       

    }
    while (PlatformUI.getWorkbench().getDisplay().readAndDispatch()) {
      // Do nothing, just wait
    }
  }

  protected void generateViewpoint(IStructuredSelection selection) {
    String vpGenerationId = "Viewpoint Generation";
    URI modelURI = ActionsUtils.getDomainURI(selection);

    String projectName = ActionsUtils.getRootProjectName(modelURI);
    Activity vpGeneratorLauncher = InvokeActivityHelper.getActivity(
        GeneratorLuncherManager.INSTANCE.getLuncherURI("Default")); //$NON-NLS-1$

    // Prepare the factory component.
    FactoryComponent factoryComponent = (FactoryComponent) vpGeneratorLauncher;
    ContractHelper.setStringContract(factoryComponent, IContractProvider.ROOT_PROJECT_NAME, projectName); //$NON-NLS-1$
    ContractHelper.setDomain(factoryComponent, IContractProvider.VPDESC_MODEL, modelURI);//$NON-NLS-1$
    ContractHelper.setBooleanContract(factoryComponent, IContractProvider.BUILD_VIEWPOINT, true); //$NON-NLS-1$
    ContractHelper.setBooleanContract(factoryComponent, IContractProvider.USER_SELECTION, false); //$NON-NLS-1$

    Diagnostic diagnostic = Diagnostician.INSTANCE.validate(factoryComponent);
    if (diagnostic.getSeverity() != Diagnostic.ERROR) 
    {
      synchronized(this) {
        try {
          ActivityManagerProducer producer = EGFProducerPlugin.getActivityManagerProducer(factoryComponent);
          final IActivityManager activityManager = producer.createActivityManager(factoryComponent);
          activityManager.initializeContext();
          Job job = new Job(vpGenerationId) {
            @Override
            public IStatus run(IProgressMonitor monitor) {
              try {
                activityManager.invoke(monitor);
                activityManager.dispose();
              } catch (InvocationException e) {
                fail("Invocation Exception");
              }
              return Status.OK_STATUS;
            }
          };
          job.setUser(true);
          job.schedule(); 
          try {
            job.join();
          } catch (InterruptedException e) {
            fail("Job Interrupted");
          }
        } catch (InvocationException e) {
          fail("Invocation Exception");
        } catch (CoreException e) {
          fail("Core Exception");
        }
      }
    }
  }

}
