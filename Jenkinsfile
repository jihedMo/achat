pipeline{
    agent any
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