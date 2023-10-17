pipeline {
    agent any
    environment {
        M2_HOME = sh(script: 'echo $M2_HOME', returnStdout: true).trim() // Récupérer la valeur de M2_HOME depuis l'environnement
    }
    stages {
        stage ('GIT') {
            steps {
                echo "Getting Project from Git"
                git branch: 'rania-amri-5sleam1', url: 'https://github.com/jihedMo/achat.git'
            }
        }
        stage('Clean'){
            steps {
                sh 'mvn clean '
            }
        }
        stage('Compile'){
            steps {
                sh "${M2_HOME}/bin/mvn compile -DskipTests"
            }
        }
    }
}
