pipeline {
          agent any
          stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'YassinBack',
                    url : 'https://github.com/dhiabenmaati/esprit-devops-repo.git';
                }

            }
            stage('MVN CLEAN'){
            steps{
                echo 'Pulling...';
                sh 'mvn clean'
                }
            }
             stage('MVN COMPILE'){
                steps{
                sh 'mvn compile'
                }
             }
             stage('MVN PACKAGE'){
                steps{
                sh 'mvn package'
                }
             }
             stage('MVN TEST'){
                steps{
                 sh 'mvn test'
                 }
             }

              stage('MVN SONARQUBE '){
                 steps{
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=esprit'
                 }
              }
              stage("nexus deploy"){
                 steps{
                  nexusArtifactUploader artifacts: [[artifactId: 'achat', classifier: '', file: '/var/lib/jenkins/workspace/devopsBackend/target/achat-1.0.jar', type: 'jar']], credentialsId: 'nexus-snapshots', groupId: 'tn.esprit.rh', nexusUrl: '192.168.0.14:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'nexus-snapshots', version: '2.2.4'
                 }
              }
              
                            stage('Build Docker Image') {
                 steps {
                 sh 'docker build -t bouchiba/spring:2.2.4 .'
                 }
              }

              stage('Push Docker Image') {
                   steps {
                     withCredentials([string(credentialsId: 'DockerhubPWS', variable: 'DockerhubPWS')]) {
                     sh "docker login -u bouchiba -p ${DockerhubPWS}"
                     }
                     sh 'docker push bouchiba/spring:2.2.4'
                   }
              }
              stage('DOCKER COMPOSE') {
                   steps {
                      sh 'docker-compose up -d --build'
                   }
              }
  
          }
              
          }



