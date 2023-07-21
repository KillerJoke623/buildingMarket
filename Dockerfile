FROM ubuntu:latest
LABEL authors="Gleb"

ENTRYPOINT ["top", "-b"]