pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                // Récupération du code depuis le dépôt Git
                checkout scm
            }
        }
        stage('Build and Compile with Maven') {
            steps {
                // Nettoyage et compilation avec Maven
                sh 'mvn clean compile'
            }
        }
    }
}
