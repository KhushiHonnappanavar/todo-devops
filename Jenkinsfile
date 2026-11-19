pipeline {
    agent any

    stages {
        stage('Build and Test') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean package'
                sh 'cp target/todoapp-0.0.1-SNAPSHOT.jar "target/todoapp-${BUILD_NUMBER}.jar"'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
