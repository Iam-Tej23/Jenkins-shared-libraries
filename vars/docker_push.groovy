def call(){
 echo"Pushing the image to dockerHub"
 withCredentials([usernamePassword(credentialsId:"dockerHub",passwordVariable:"DOCKER_PASS",usernameVariable:"DOCKER_USER")]){
 sh "docker login -u ${env.DOCKER_USER} -p ${env.DOCKER_PASS}"
 sh "docker image tag app:latest ${env.DOCKER_USER}/app:latest"
 sh "docker push ${env.DOCKER_USER}/app:latest"
                }
}
