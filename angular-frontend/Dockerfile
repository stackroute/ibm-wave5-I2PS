FROM node:12

WORKDIR /app

COPY . .

RUN npm install

RUN npm run build

RUN npm install -g http-server

WORKDIR /app/dist/your-angular-project

CMD ["http-server", "-p", "8042"]
