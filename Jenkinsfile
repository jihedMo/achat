pipeline{
    agent any
	 environment {
            DOCKERHUB_CREDENTIALS=credentials('dockerhub')
    }

    stages {


        stage ('GIT') {
            steps {
               echo "Getting Project from Git";
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
                sh 'mvn compile -DskipTests'
            }

        }







}
}