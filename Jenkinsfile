node('local') {
    stage('Checkout') {
        echo 'Checkout...'
        checkout scm
    }

    stage('Build CI Docker Image') {
        echo 'Build...'
        dir('docker') {
            sh 'rm -rf persona_backend'
            sh 'mkdir persona_backend'
            sh 'cp -rf ../src ./persona_backend'
            sh 'cp ../build.gradle ./persona_backend'
            sh 'docker build -t persona_backend:ci -f ci.Dockerfile .'
            sh 'rm -rf persona_backend'
        }
    }

    stage('Unit Test') {
        echo 'test...'
        sh 'gradle test'
    }

    stage('Build Production Docker Image') {
        echo 'Build...'
        sh 'gradle buildDocker -x test'
    }
}