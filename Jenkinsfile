pipeline {
    agent any
    environment {
        PATH = "/opt/maven/bin:$PATH"
        JAVA_HOME = "/usr/lib/jvm/java-1.11.0-openjdk-amd64"
         NEXUS_VERSION="nexus3"
                 NEXUS_PROTOCOL="https"
                  NEXUS_URL="192.168.1.158:8081"
                  NEXUS_REPOSITORY="Nexus Repository"
                 NEXUS_CREDENTIAL_ID="nexus-user-credentials"
    }
    stages {
        stage('GIT') {
            steps {
                echo "Getting Project from Git"
                git branch: 'rania-amri-5sleam1', url: 'https://github.com/jihedMo/achat.git'
            }
        }
        stage('Clean') {
            steps {
                sh 'mvn clean '
            }
        }
        stage('Compile') {
            steps {
                script {
                    def mavenHome = sh(returnStdout: true, script: 'echo $M2_HOME').trim()
                    sh "${mavenHome}/bin/mvn compile -DskipTests"
                }
            }
        }
          stage('NEXUS'){

                     steps{
                         sh 'mvn deploy '
                     }
           stage('SonarQube analysis') {
                steps {
                    script {
                        withSonarQubeEnv(credentialsId: 'SonarQube_Token') {
                            sh """
                                mvn clean package sonar:sonar \
                                -Dsonar.sonar -Dsonar.password=sonar
                            """
                        }
                    }
                }
            }
         }
     }
