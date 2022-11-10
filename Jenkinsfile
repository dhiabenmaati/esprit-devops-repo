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

    stage('Cleaning the project') {
      steps {
        sh "mvn -B -DskipTests clean  "
      }
    }

    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }
    
    
    stage("SonarQube Analysis") {
      steps {

        withSonarQubeEnv('sonar') {
          sh 'mvn clean -DskipTests package sonar:sonar'
        }
      }
    }
    
  }
}
