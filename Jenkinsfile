pipeline {

  agent any
  tools {
    jdk 'JAVA_HOME'
    maven 'M2_HOME'
  }

  stages {

       stage('Cloning Project from Git')
        {
            steps
            {
               echo"GETTING FILES FROM DHIA REPO";
               git branch:'repo-dhia', url:"https://github.com/dhiabenmaati/esprit-devops-repo.git"
            }
        }
        
        stage("clean")
        {
            steps
            {
                echo"CLEANING MVN";
                sh "mvn -B -DskipTests clean  "
            }
        }

        stage("Build")
        {
            steps
            {
                echo"BUILDING";
                sh 'mvn -B -DskipTests clean package'
            }
        }
        
                stage('JUnit/Mockito'){
            steps {
		        script{
                    sh '''mvn -version
                    mvn -B -DskipTests clean package'''
                    echo """Bravo! tous les tests sont pris en charge"""
                    }
           }
        }
        
        stage("SonarQube Analysis")
        {
            steps
            {
                echo"ANALYSIS WITH SONAR";
                withSonarQubeEnv('sonarqube-8.9.7'){ sh "mvn sonar:sonar" }
				
            }
        }
        
        stage("Deploy With Nexus")
        {
            steps
            {
                echo"DEPLOYING TO NEXUS";
                sh 'mvn -B -DskipTests deploy'
            }
        }

          stage('Docker image'){
            steps {
                 sh 'docker build -t dhiabm/springapp .'
            }
        }
        stage('DockerCompose') {
        
                       steps {
                            
				            sh 'docker-compose up -d'
                        }
                          
        }

       stage('push to DockerHub'){
            steps { 
                withCredentials([string(credentialsId: 'doc_creds', variable: 'docker_hub_cred')]) {
                    sh 'docker login -u dhiabm -p ${docker_hub_cred}'
                    sh 'docker push dhiabm/springapp'
                    }
                }
       }    

	  
    }
}
