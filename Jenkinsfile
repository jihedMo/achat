pipeline{
    agent any
    stages {


        stage ('GIT') {
            steps {
               echo "Getting Project from Git";
               sh 'git checkout rania-amri-5sleam1'

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