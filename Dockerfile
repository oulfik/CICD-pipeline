# Dockerfile for build image
FROM node:slim
COPY . .
CMD [ "node", "server.js" ]