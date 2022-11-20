FROM node:slim
COPY . .
CMD [ "node server.js" ]