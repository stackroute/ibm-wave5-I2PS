FROM node:12

WORKDIR /app

COPY . .

RUN npm install

RUN npm install http-server -g

RUN npm run build

WORKDIR /app/dist/angular-frontend

RUN ls -la

ENTRYPOINT ["http-server", "-c1", "-p", "8042"]
