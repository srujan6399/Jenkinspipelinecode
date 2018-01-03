pipeline{
    agent{
        docker { image 'jenkins' }
    }
    stages{
        stage('docker'){
            steps{
                script{
                    echo 'Test'
                }
            }
        }
    }
}