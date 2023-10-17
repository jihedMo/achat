pipeline {
    agent any
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
    }
}
