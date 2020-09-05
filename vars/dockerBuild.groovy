def login() {
    withCredentials([usernamePassword9credentialsId: 'docker.hub', usernameVariable: 'hubUsername', passwordVariable: 'hubPassword']) {
        sh """
            docker login --username="${hubUsername}" --password="${hubPassword}"
        """
    }
}

def build(String tag) {
    sh """
        docker build -t "${tag}" .
    """
}

def push(String tag) {
    sh """
        docker push "${tag}"
    """
}