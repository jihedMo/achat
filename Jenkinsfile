pipeline {
    agent any

    stages {
        stage('Récupération du code de la branche') {
            steps {
                git branch: 'jihed-mohamed-5sleam' , 
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
          stage('JUnit/Mockito') {
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
        stage('SonarQube') {
            steps {
                // Provide SonarQube authentication using the provided token
                withCredentials([string(credentialsId: 'achatDevops', variable: 'SONAR_TOKEN')]) {
                    sh "mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN"
                }
            }
        }
stage('Publish Artifacts to Nexus') {
            steps {
                script {
                    nexusArtifactUploader artifacts: [[
                        artifactId: 'achat',
                        classifier: '',
                        file: 'target/achat-1.0.jar',
                        type: 'jar']],
                        credentialsId: 'Nexus',
                        groupId: 'tn.esprit.rh',
                        nexusUrl: '192.168.100.7:8081',
                        nexusVersion: 'nexus3',
                        protocol: 'http',
                        repository: 'jihed_mohamed_5sleam1/',
                        version: '1.0'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image (replace 'Dockerfile' with your Dockerfile location)
                    sh 'docker build -t jnounou/achat:1.0 -f Dockerfile .'
                }
            }
        }

        stage('Push to DockerHub') { 
            steps { 
                script { // Log in to DockerHub using the credentials 
                        withCredentials([string(credentialsId: 'dockerhub_hub', variable: 'DOCKERHUB_PASSWORD')]) { 
                        sh "docker login -u jnounou -p ${DOCKERHUB_PASSWORD}" 
                         } 
                           // Push the Docker image to DockerHub 
                         sh 'docker push jnounou/achat:1.0'
                                                    }
                                               }
                                       }
          stage('Deploy with Docker Compose') {
            steps {
                    sh 'docker-compose up -d'  // Use -d to run in detached mode
            
                }
            }
                stage('Grafana/prometheus') {
            steps {
                sh 'docker start 2fe92f506ba0'
                sh 'docker start 36d4bab685ef'
            }
        }
        stage('Jacoco Report') {
    steps {
        script {
            // Exécutez la génération des rapports Jacoco
            sh "mvn jacoco:report"
            
            // Publiez les rapports Jacoco dans Jenkins
            step([$class: 'JacocoPublisher', execPattern: '**/target/jacoco.exec', classPattern: '**/target/classes', sourcePattern: '**/src/main/java'])
        }
    }
}
stage('jacoco Test') {
    steps {

        // Generate JaCoCo code coverage reports
        jacoco(execPattern: '**/target/jacoco.exec', classPattern: '**/target/classes')
    }
}
stage('Publish JaCoCo Reports') {
    steps {
        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'target/site/jacoco/', reportFiles: 'jacoco.csv', reportName: 'JaCoCo Code Coverage Report', reportTitles: ''])
    }
}

    }
}
