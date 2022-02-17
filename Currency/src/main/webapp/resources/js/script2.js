const url = 'https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5';
const xhr = new XMLHttpRequest();
xhr.open('GET', url);

xhr.addEventListener("readystatechange", (e) => {
    if (xhr.readyState === xhr.DONE) {
        if (xhr.status === 200) {
            console.log(xhr.responseType);
            const json = xhr.responseText;
            const data = JSON.parse(json);
            console.log(data);

            // document.querySelector('.usd').textContent = data[0]['base_ccy'] + " " + data[0]['buy'] + " " + data[0]['ccy'] + " " + data[0]['sale'];
            // document.querySelector('.eur').textContent = data[1]['base_ccy'] + " " + data[1]['buy'] + " " + data[1]['ccy'] + " " + data[1]['sale'];
            // document.querySelector('.rur').textContent = data[2]['base_ccy'] + " " + data[2]['buy'] + " " + data[2]['ccy'] + " " + data[2]['sale'];
            // document.querySelector('.btc').textContent = data[3]['base_ccy'] + " " + data[3]['buy'] + " " + data[3]['ccy'] + " " + data[3]['sale'];
            document.querySelector('.usd1').textContent = data[0]['buy'];
            document.querySelector('.usd2').textContent = data[0]['sale'];
            document.querySelector('.eur1').textContent = data[1]['buy'];
            document.querySelector('.eur2').textContent = data[1]['sale'];
            document.querySelector('.rur1').textContent = data[2]['buy'];
            document.querySelector('.rur2').textContent = data[2]['sale'];

        }
    }
});
xhr.send();
