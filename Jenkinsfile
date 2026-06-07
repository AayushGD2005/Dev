pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/AayushGD2005/Dev.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat '''
                    mvn sonar:sonar ^
                    -Dsonar.projectKey=Dev ^
                    -Dsonar.projectName=Dev
                    '''
                }
            }
        }

        stage('Dependency Check') {
            steps {
                dependencyCheck additionalArguments: '--scan .',
                                odcInstallation: 'DependencyCheck'
            }
        }

        stage('Publish Dependency Report') {
            steps {
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }

        failure {
            echo 'Pipeline failed!'
        }
    }
}
