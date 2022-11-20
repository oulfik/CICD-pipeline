pipeline {
    environment {
        registry = "oliulf/jenkins-docker-test"
        DOCKER_PWD = credentials('dockerhub-creds')
    }
    agent {
        docker {
            image 'oliulf/jenkins:1.0'
            args '-p 3000:3000'
            args '-w /app'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage("Build"){
            steps {
                sh 'npm install'
            }
        }
        stage("Test"){
            steps {
                sh 'npm test'
            }
        }
        stage("Build & Push Docker image") {
            steps {
                sh 'docker image build -t $registry:$BUILD_NUMBER .'
                sh 'docker login -u oliulf -p $DOCKER_PWD'
                sh 'docker image push $registry:$BUILD_NUMBER'
                sh "docker image rm $registry:$BUILD_NUMBER"
            } 
        }

        stage('Deploy and smoke test') {
            steps{
                sh './scripts/deploy.sh'
            }
        }

        stage('Cleanup') {
            steps{
            sh './scripts/cleanup.sh'
            }
        }
    }
}