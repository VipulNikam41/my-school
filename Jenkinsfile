pipeline {
    agent any
    stages {
        stage("build") {
            steps {
                echo 'building application'
                sh 'mvn clean -Dmaven.test.skip=true install'
            }
        }
        stage("test") {
            steps {
                echo 'testing application'
                sh 'mvn test'
            }
        }
        stage("deploying") {
            steps {
                echo 'deploying application'
            }
        }
    }
}