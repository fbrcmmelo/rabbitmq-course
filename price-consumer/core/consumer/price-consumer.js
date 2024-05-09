const amqp = require('amqplib');
const PRICE_QUEUE = 'PRICE';

amqp.connect({
	port: 5672,
	hostname: 'localhost',
	username: 'admin',
	password: 123456,
}).then(con => {
	con.createChannel()
	.then(channel => channel.consume(PRICE_QUEUE, (msg) => {
		console.log('Consuming new message from QUEUE ', PRICE_QUEUE );
		console.log('Message: ', msg.content.toString());
	}))
	.catch(error => console.log(error))
})
.catch(error => console.log(error))