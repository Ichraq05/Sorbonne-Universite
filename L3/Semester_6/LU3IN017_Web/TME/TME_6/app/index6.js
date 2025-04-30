const express = require('express')
const session = require('express-session')

const app = express()

app.use(session({
  secret: 'monmotdepassesecret',  // phrase secrète
  resave: false,  // don't save session if unmodified
  saveUninitialized: false  // pas de création de session tant que rien n'est sauvegardé
}))

app.get('/', (req, res) => {
  if (req.session.user) {
    res.setHeader('Content-Type', 'text/plain; charset=UTF-8');
    res.status(200);
    res.write('Déjà de retour, '+req.session.user+ "?")
    res.end()
  } else {
    req.session.user = "toi"
    res.setHeader('Content-Type', 'text/plain; charset=UTF-8');
    res.status(200);
    res.end("Bienvenue")
  }
})

app.listen(3000)