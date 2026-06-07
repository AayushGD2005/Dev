pipeline {
    agent any

    tools {
        jdk 'JDK26'
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/AayushGD2005/Dev.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'SonarScanner'
                    withSonarQubeEnv('SonarQube') {
                        bat """
                        ${scannerHome}\\bin\\sonar-scanner.bat ^
                        -Dsonar.projectKey=Dev ^
                        -Dsonar.projectName=Dev ^
                        -Dsonar.sources=src
                        """
                    }
                }
            }
        }
    }
}
