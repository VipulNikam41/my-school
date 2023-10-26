pipeline {
    agent any
    environment {
        MVN_VERSION = '3.9.4'
    }
    tools {
        maven 'Maven'
    }
    stages {
        stage("Building Project") {
            steps {
                echo "Building application with mvn version ${MVN_VERSION}"
                sh 'mvn clean -Dmaven.test.skip=true install'
            }
        }
        stage("Running Tests") {
            steps {
                echo 'testing application'
                sh 'mvn test'
            }
        }
        stage("SonarQube Analysis") {
            steps {
                echo 'TODO'
            }
        }
    }
    post {
        always {
            echo 'Process completed'
        }
        failure {
            echo 'Failure. Need to send email notification'
        }
        success {
            echo 'Success. Need to send push notification'
        }
    }
}