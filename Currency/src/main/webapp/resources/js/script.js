const sumBlock = document.getElementById("sum");
const amountBlock = document.getElementById("amount");
const buy_currency = document.getElementById("buy-currency");
const sell = document.getElementById("sell-currency");
const ajax = fetch('https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json');
let data;
ajax.then(data => data.json()).then(result => {
    data = result;
    amountBlock.addEventListener("blur", currencyHandler);
    sell.addEventListener("change", currencyHandler)
});

function currencyHandler() {
    const currencyCalculationSettings = {
        buy: null, sell: null
    }
    const currencySettings = {
        buy: document.getElementById("buy-currency").value,
        sell: document.getElementById("sell-currency").value
    }
    console.log(currencySettings.sell);
    console.log(currencySettings.buy);
    data.forEach((currencyPreset) => {
        if (currencyPreset.cc === currencySettings.sell) {
            currencyCalculationSettings.sell = currencyPreset;
        }
        if (currencyPreset.cc === currencySettings.buy) {
            currencyCalculationSettings.buy = currencyPreset;
        }
    });
    calculateCurrency(currencyCalculationSettings);
}

function calculateCurrency(settings) {
    const currentAmount = amountBlock.value;
    if (settings.buy == null) {
        settings.buy = {
            rate: 1
        }
    }
    if (settings.sell == null) {
        settings.sell = {
            rate: 1
        }
    }
    const UAHSellAmount = currentAmount * settings.buy.rate;
    const foreignCurrencyBuy = UAHSellAmount / settings.sell.rate;
    console.log(foreignCurrencyBuy);
    sumBlock.value = foreignCurrencyBuy.toFixed(2);
}

buy_currency.addEventListener("blur", (e) => {
    const index = buy_currency.selectedIndex;
    for (let i = 0; i < sell.children.length; i++) {
        sell.children[i].disabled = false;
    }
    sell.children[index].disabled = true;
});


document.getElementById("currency")
    .addEventListener("submit", (e) => {
        let id = document.getElementById("userId");
       e.preventDefault();
        fetch("/exchange/" + id.value + "",
            {
                method: "POST",
                body: JSON.stringify({
                    sell: sell.value,
                    buy: buy_currency.value,
                    amount: amountBlock.value,
                    sum: sumBlock.value,
                }), headers : {
                    'Content-type' : 'application/json'
                }
            })
        .then(resp => {
            if(Math.floor(resp.status / 100) === 2) {
                //alert("success");
                window.location.replace("http://localhost:8080/exchange/" + id.value +"")
            } else {
                // may be some wrong
            }
        });
    });