const tambah = () => {
    var bil_1 = document.getElementById("bil-1")
    var bil_2 = document.getElementById("bil-2")
    var hasil = document.getElementById("hasil")

                        // casting to type number
    hasil.innerHTML = (+bil_1.value) + (+bil_2.value)
}

const kali = () => {
    var bil_1 = document.getElementById("bil-1")
    var bil_2 = document.getElementById("bil-2")
    var hasil = document.getElementById("hasil")

    hasil.innerHTML = bil_1.value * bil_2.value
}

const clean = () => {
    document.getElementById("hasil").innerHTML = ""
}