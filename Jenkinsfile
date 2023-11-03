pipeline {
    agent any
    environment {
        registry = "rania2023/rania-amri-5sleam1"
        registryCredential = 'DockerHub'
        dockerImage = ''

        NEXUS_VERSION="nexus3"
         NEXUS_PROTOCOL="https"
          NEXUS_URL="192.168.1.158:8081"
          NEXUS_REPOSITORY="Nexus Repository"
         NEXUS_CREDENTIAL_ID="nexus-user-credentials"


    }
    }

    stages {
        stage('Cloning our Git') {
            steps {
                git branch: 'rania-amri-5sleam1', url: 'https://github.com/jihedMo/achat.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("$registry:$BUILD_NUMBER")
                }
            }
        }

        stage('Deploy Docker Image') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }

        stage('SonarQube analysis') {
            steps {
                script {
                    withSonarQubeEnv(credentialsId: 'SonarQube_Token') {
                        sh """
                            mvn clean package sonar:sonar \
                            -Dsonar.login=votre_nom_utilisateur -Dsonar.password=votre_mot_de_passe
                        """
                    }
                }
            }
        }

        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn compile -DskipTests'
            }
        }

        stage('UNIT test'){
            steps{
                sh 'mvn test'
            }
        }

          stage('NEXUS'){

             steps{
                 sh 'mvn deploy '
             }

    }
}