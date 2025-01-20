# !/bin/bash/


APP="app-tokio"
VERSION="0.0.9"
REGISTRY="rodrigo1983developer/$APP:$VERSION"

#docker stop $APP

#docker rm $APP

#docker rmi "$APP:$VERSION"

docker build -t "$APP:$VERSION" .

docker tag "$APP:$VERSION" $REGISTRY

docker push $REGISTRY

docker compose up -d

#docker compose up



