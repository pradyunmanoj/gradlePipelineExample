pipeline {

    agent any

    options {

        disableConcurrentBuilds()

    }

    stages {

        stage('Gradle Build') {

            steps {

                sh 'gradle clean build'

            }

        }

        stage('Gradle Test') {

            steps {

                sh 'gradle clean test'

            }
        }

        stage('Gradle Building Deployment Artifacts') {

            steps {

                sh 'gradle clean stage'

            }
        }

    }

}