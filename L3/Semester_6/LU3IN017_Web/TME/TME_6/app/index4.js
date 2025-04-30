const express = require ('express');

const router = express.Router();

const app = express();
const port = 8000;

router.use(express.json());

router.get('/', (req, res) => {
	res.setHeader('Content-Type', 'text/plain;charset=UTF-8');
	res.send("Serveur à l'écoute");	
})
.post('/api', (req, res) =>{
	console.log(req.body.name);
	res.json({addition: Number(req.body.nb1)+Number(req.body.nb2),prop: "hello"});
	res.end();
})
.use(function (req, res, next) {
	res.setHeader('Content-Type', 'text/plain;charset=UTF-8');
	res.status(404).send("Cette page n'existe pas.");
});

app.use('/', router);

app.listen(port, function() {
	console.log('Le serveur écoute le port '+port);
});
