pipeline {
  agent { label 'migration' }
  
  tools {
        maven 'apache-maven-latest'
        jdk 'oracle-jdk8-latest'
  }
  stages {
    stage('Package & test Capella Studio') {
      steps {
      	wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
        	sh 'mvn  -Dmaven.test.failure.ignore=true -Dtycho.localArtifacts=ignore clean verify -P full -P sign -P product -e -f pom.xml'
        }
      }
    }
    stage('Archive artifacts') {
      steps {
        archiveArtifacts artifacts: 'releng/plugins/org.polarsys.capella.studio.releng.product/target/*.txt, releng/plugins/org.polarsys.capella.studio.releng.updatesite/target/repository/**, releng/plugins/org.polarsys.capella.studio.releng.updatesite/target/*.txt'
      }
    }
    stage('Deploy') {
      steps {
          sshagent ( ['projects-storage.eclipse.org-bot-ssh']) {
          	script {
          		def VERSION='master'
          		if (changeRequest()) {
          			VERSION=BRANCH_NAME
          		}
	            	
                        def DEST_UPDATESITE_DIR='/home/data/httpd/download.eclipse.org/capella/capellastudio/updates/nightly/'+VERSION
                        def DEST_PRODUCT_DIR='/home/data/httpd/download.eclipse.org/capella/capellastudio/products/nightly/'+VERSION
				
				sh "echo 'deploy update site'"
				sh "ssh genie.capella@projects-storage.eclipse.org rm -rf ${DEST_UPDATESITE_DIR}"
				sh "ssh genie.capella@projects-storage.eclipse.org mkdir -p ${DEST_UPDATESITE_DIR}"
				sh "scp -r releng/plugins/org.polarsys.capella.studio.releng.updatesite/target/repository/* genie.capella@projects-storage.eclipse.org:${DEST_UPDATESITE_DIR}"
				
				sh "echo 'deploy product'"
				sh "ssh genie.capella@projects-storage.eclipse.org rm -rf ${DEST_PRODUCT_DIR}"
				sh "ssh genie.capella@projects-storage.eclipse.org mkdir -p ${DEST_PRODUCT_DIR}"
				sh "scp -r releng/plugins/org.polarsys.capella.studio.releng.product/target/products/*.zip genie.capella@projects-storage.eclipse.org:${DEST_PRODUCT_DIR}"
	        }
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