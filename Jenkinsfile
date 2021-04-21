pipeline {
	agent { label 'migration' }

	tools {
		maven 'apache-maven-latest'
		jdk 'openjdk-jdk14-latest'
	}
	stages {
		stage('Package & test Capella Studio') {
			steps {
				wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
					script {
						def jacocoPrepareAgent = "-Djacoco.destFile=${WORKSPACE}/jacoco.exec -Djacoco.append=true org.jacoco:jacoco-maven-plugin:0.8.6:prepare-agent"
						sh "mvn -Dmaven.test.failure.ignore=true -Dtycho.localArtifacts=ignore ${jacocoPrepareAgent} clean verify -P full -P sign -P product -P test -e -f pom.xml"
					}  		
				}
			}
		}
		stage('Archive artifacts') {
			steps {
				archiveArtifacts artifacts: 'releng/plugins/org.polarsys.capella.studio.releng.product/target/*.txt, releng/plugins/org.polarsys.capella.studio.releng.updatesite/target/repository/**, releng/plugins/org.polarsys.capella.studio.releng.updatesite/target/*.txt'
			}
		}
		stage('Deploy') {
			when {
				anyOf {
					branch pattern : "v\\d\\.\\d\\.x", comparator: "REGEXP";
					branch 'master'    	      
				}
			}
			steps {
				sshagent ( ['projects-storage.eclipse.org-bot-ssh']) {
					script {
						def VERSION = BRANCH_NAME
						if (VERSION.matches("v\\d\\.\\d\\.x")) {
							VERSION = VERSION.substring(1)
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
		stage('Publish tests results') {
			steps {
				junit allowEmptyResults: true, testResults: '*.xml,**/target/surefire-reports/*.xml'
				sh "mvn -Djacoco.dataFile=${WORKSPACE}/jacoco.exec org.jacoco:jacoco-maven-plugin:0.8.6:report -P full -P test -e -f pom.xml"
			}
		}
		stage('Perform Sonar analysis') {
			environment {
			    SONARCLOUD_TOKEN = credentials('sonar-token-capella-studio')
			}
			steps {
				withEnv(['MAVEN_OPTS=-Xmx4g']) {
					script {
						def jacocoParameters = "-Dsonar.java.coveragePlugin=jacoco -Dsonar.core.codeCoveragePlugin=jacoco "
						def javaVersion = "8"
						def sonarCommon = "sonar:sonar -Dsonar.projectKey=eclipse_capella-studio -Dsonar.organization=eclipse -Dsonar.host.url=https://sonarcloud.io -Dsonar.login='$SONARCLOUD_TOKEN' -Dsonar.skipDesign=true -Dsonar.dynamic=reuseReports -Dsonar.java.source=${javaVersion} -Dsonar.scanner.force-deprecated-java-version=true "
						def sonarBranchAnalysis = "-Dsonar.branch.name=${BRANCH_NAME}"
						def sonarPullRequestAnalysis = ("${BRANCH_NAME}".contains('PR-') ? "-Dsonar.pullrequest.provider=GitHub -Dsonar.pullrequest.github.repository=eclipse/capella-studio -Dsonar.pullrequest.key=${CHANGE_ID} -Dsonar.pullrequest.branch=${CHANGE_BRANCH}" : "")
						def sonar = sonarCommon + jacocoParameters + ("${BRANCH_NAME}".contains('PR-') ? sonarPullRequestAnalysis : sonarBranchAnalysis)
						sh "mvn ${sonar} -P full -P test -e -f pom.xml"
					}
				}                      
			}
		}
	}
	post {
		always {
			archiveArtifacts artifacts: '**/*.log,**/*.layout'
		}
	}
}