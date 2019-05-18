pipeline{
    agent none
    stages{
        stage('checkout'){
            agent{
                label 'agent-linux-01'
            }
            steps{
                script{

                }
            }
        }
    }
}