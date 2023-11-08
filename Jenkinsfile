pipeline {
    agent any
 tools{
         maven 'M2_HOME'
     }
    stages {
        stage('Récupération du code de la branche') {
            steps {
                git branch: 'sirine_karoui_5sleam1' , 
                url : 'https://github.com/jihedMo/achat.git';
            }
        }

        stage('Nettoyage et compilation avec Maven') {
            steps {
                // Étape de nettoyage du projet
                sh "mvn clean"

                // Étape de compilation du projet
                sh "mvn compile"
            }
        }
      
          stage('Exécution des tests') {
            steps {
                sh "mvn test "  // Run JUnit tests
            }

        }
         stage("Maven Build") {
            steps {
                script {
                    sh "mvn package -DskipTests=true"
                }
            }
        } 
        stage('MVN NEXUS') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true';
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image (replace 'Dockerfile' with your Dockerfile location)
                    sh 'docker build -t sirinekaroui/achat:1.0 -f Dockerfile .'
                }
            }
        }

        stage('Push to DockerHub') { 
            steps { 
                script { // Log in to DockerHub using the credentials 
                        withCredentials([string(credentialsId: 'docker', variable: 'DOCKERHUB_PASSWORD')]) { 
                        sh "docker login -u sirinekaroui -p ${DOCKERHUB_PASSWORD}" 
                         } 
                           // Push the Docker image to DockerHub 
                         sh 'docker push sirinekaroui/achat:1.0'
                                                    }
                                               }
                                       }
          stage('Deploy with Docker Compose') {
            steps {
                    sh 'docker-compose up -d'  // Use -d to run in detached mode
            
                }
            }
  stage('SonarQube') {
            steps {
                // Provide SonarQube authentication using the provided token
                withCredentials([string(credentialsId: 'achattoken', variable: 'SONAR_TOKEN')]) {
                    sh "mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN"
                }
            }
        }

                
       
        

    }
}
