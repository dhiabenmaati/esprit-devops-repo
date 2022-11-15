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



}
}
