# language: pt
Funcionalidade: Reserva de carro por aplicativo
  Como passageiro de um aplicativo de transporte
  Quero reservar um carro informando meu local
  Para que eu possa me deslocar com comodidade e segurança

  Cenário: Reserva dentro da área de cobertura
    Dado que o passageiro está na cidade "Belo Horizonte"
    E informa o endereço "Rua A, 123"
    Quando solicitar a reserva do carro
    Então o sistema deve retornar "Motorista a caminho"

  Cenário: Reserva fora da área de cobertura
    Dado que o passageiro está na cidade "Betim"
    E informa o endereço "Rua B, 456"
    Quando solicitar a reserva do carro
    Então o sistema deve retornar "Área fora de cobertura"