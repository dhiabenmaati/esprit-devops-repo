pipeline {

  agent any
  tools {
    jdk 'JAVA_HOME'
    maven 'M2_HOME'
  }

  environment {
    DOCKERHUB_CREDENTIALS = credentials('dockerhub')
  }

  stages {

   stage('Cloning Project from Git') {
steps {
     
   sh  "git clone 'https://github.com/dhiabenmaati/esprit-devops-repo.git'" 
   sh "git branch"

    }}

stage("Build") {
steps {
sh "mvn compile"
}}

stage("Unit tests") {
steps {
sh "mvn test"
}}

stage("Static tests") {
steps {
sh "mvn sonar:sonar -Dsonar.projectKey=test -Dsonar.host.url=http://localhost:9000 -Dsonar.login=d8621a77b34a8277fd5fba7d56dd1b3fdecf7d07"
}}

stage("clean and packaging") {
steps {
sh "mvn clean package "
}}


}
}
