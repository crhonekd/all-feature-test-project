pipeline {
    agent any
tools { 
        maven 'Maven 3.3.9' 
        jdk 'jdk8' 
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
                stage('Clean') {
            steps {
                echo 'Cleanig..'
                sh 'mvn clean'
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn install -DskipTests'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
