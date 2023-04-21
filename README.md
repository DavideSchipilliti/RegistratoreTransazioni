# RegistratoreTransazioni
 
Esercizio
Scrivere un insieme di classi che registrino le transazioni economiche in valute internazionali effettuate da una ditta, quali pagamenti ricevuti ed effettuati.

Un registratore di transazioni economiche sia caratterizzato dai seguenti dati:
- sequenza delle transazioni effettuate
- saldo

Una transizione economica sia caratterizzata dai seguenti dati:
- data di effettuazione,
- quantita' di danaro trattata
- commissione in caso di prelievo/pagamento
- tipo di transazione: versamento o prelevamento.

Una quantità di denaro sia, a sua volta, caratterizzata dai seguenti dati:
-tipo di valuta (es.: euro, dollaro, sterlina)
-importo

Il programma deve fornire le seguenti funzionalità:
- creare un nuovo registratore di transazioni con saldo iniziale.
- aggiungere una transazione, memorizzandola e aggiornando il saldo
- fornire il saldo
- fornire l'elenco delle transazioni effettuate nell'ordine in cui sono state registrate


Scrivere, successivamente una classe di prova che:
acquisisca i dati da standard input
stampi l'elenco delle operazioni
stampi il saldo
