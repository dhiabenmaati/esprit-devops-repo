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
    
    stage('JUnit/Mockito') {
      steps {
        script {
          sh ''
          'mvn -version
          mvn - B - DskipTests clean package ''
          '

          echo ""
          "Bravo! tous les tests sont pris en charge"
          ""
        }
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
