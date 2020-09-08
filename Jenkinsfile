pipeline {
  agent { label 'migration' }
  
  tools {
        maven 'apache-maven-latest'
        jdk 'oracle-jdk8-latest'
  }
  environment {
    FROM_PR = "${env.BRANCH_NAME}".contains("PR-");
  } 
  stages {
    stage('Package & test Capella Studio') {
      steps {
      	wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
        	sh 'mvn  -Dmaven.test.failure.ignore=true -Dtycho.localArtifacts=ignore clean verify  -e -f pom.xml'
        }
      }
    }
    stage('Archive artifacts') {
      steps {
        archiveArtifacts artifacts: 'releng/plugins/org.polarsys.capella.studio.releng.product/target/products/*.zip, releng/plugins/org.polarsys.capella.studio.releng.product/target/*.txt, releng/plugins/org.polarsys.capella.studio.releng.updatesite/target/repository/**, releng/plugins/org.polarsys.capella.studio.releng.updatesite/target/*.txt'
      }
    }
    stage('Deploy PR') {
      when {
         changeRequest()
      }
      steps {
          sshagent ( ['projects-storage.eclipse.org-bot-ssh']) {
            sh '''
            	echo ${env.BRANCH_NAME}
            	env
            	
			  
            '''
        }
      }
    }
    stage('Deploy nigthly') {
      when {
         not { changeRequest() }
      }
      steps {
          sshagent ( ['projects-storage.eclipse.org-bot-ssh']) {
            sh '''
            	VERSION=1.4.x
            	DEST_UPDATESITE_DIR=/home/data/httpd/download.eclipse.org/capella/capellastudio/updates/nightly/$VERSION
            	DEST_PRODUCT_DIR=/home/data/httpd/download.eclipse.org/capella/capellastudio/products/nightly/$VERSION
				
				echo "deploy update site"
				ssh genie.capella@projects-storage.eclipse.org rm -rf $DEST_UPDATESITE_DIR
				ssh genie.capella@projects-storage.eclipse.org mkdir -p $DEST_UPDATESITE_DIR
				scp -r releng/plugins/org.polarsys.capella.studio.releng.updatesite/target/repository/* genie.capella@projects-storage.eclipse.org:$DEST_UPDATESITE_DIR
				
				echo "deploy product"
				ssh genie.capella@projects-storage.eclipse.org rm -rf $DEST_PRODUCT_DIR
				ssh genie.capella@projects-storage.eclipse.org mkdir -p $DEST_PRODUCT_DIR
				scp -r releng/plugins/org.polarsys.capella.studio.releng.product/target/products/*.zip genie.capella@projects-storage.eclipse.org:$DEST_PRODUCT_DIR
			  
            '''
        }
      }
    }
  }
  post {
    always {
       archiveArtifacts artifacts: '**/*.log,**/*.layout'
       junit '**/target/surefire-reports/*.xml'
    }
  }
  
}