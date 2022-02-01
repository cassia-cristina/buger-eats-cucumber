package steps;

import core.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static org.junit.Assert.*;

import pages.DeliverPage;
import pages.HomePage;

import java.util.Map;

public class SignupSteps {
    HomePage homePage;
    DeliverPage deliverPage;
    Map<String, String> entregador;

    @Before
    public void setup() {
        new Driver();
    }

    @After
    public void tearDown() {
        Driver.getDriver().quit();
    }

    @Dado("que esteja na pagina da BugerEats")
    public void queEstejaNaPaginaDaBugerEats() {
        Driver.getDriver().get("https://buger-eats-qa.vercel.app/");
        homePage = new HomePage();
        String titulo = homePage.getTitulo();
        assertEquals("Seja um parceiro entregador pela Buger Eats", titulo);
    }

    @E("for realizado um clique em Cadastre-se para fazer entregas")
    public void forRealizadoUmCliqueEmCadastreSeParaFazerEntregas() {
        homePage.clickBtnCadastreSe();
    }

    @Quando("os seguintes dados forem informados")
    public void osSeguintesDadosForemInformados(Map<String, String> map) {
        deliverPage = new DeliverPage();
        entregador = map;
        deliverPage.setInputName(entregador.get("nome"));
        deliverPage.setInputCpf(entregador.get("cpf"));
        deliverPage.setInputEmail(entregador.get("email"));
        deliverPage.setInputWhatsapp(entregador.get("whatsapp"));
        deliverPage.setInputPostalCode(entregador.get("cep"));
        deliverPage.setInputNumber(entregador.get("numero"));
        deliverPage.setInputAddressDetails(entregador.get("complemento"));
        deliverPage.setDeliveryMethod(entregador.get("metodoEntr"));
    }

    @E("for realizado um clique em Buscar CEP")
    public void forRealizadoUmCliqueEmBuscarCEP() {
        deliverPage.clickBtnCep();
    }

    @E("for selecionado um arquivo para a foto CNH")
    public void forSelecionadoUmArquivoParaAFotoCNH() {
        deliverPage.uploadCnh();
    }

    @E("o formulario for submetido")
    public void oFormularioForSubmetido() {
        deliverPage = new DeliverPage();
        deliverPage.clickBtnCadastreSe();
    }

    @Entao("deve mostrar mensagem de dados recebidos com sucesso")
    public void deveMostrarMensagemDeDadosRecebidosComSucesso() {
        String message = deliverPage.getMessageModal();
        String expectedMessage = "Recebemos os seus dados. Fique de olho na sua caixa de email, pois e em breve retornamos o contato.";
        assertEquals(expectedMessage, message);
    }

    @Entao("deve mostrar uma mensagem de erro")
    public void deveMostrarUmaMensagemDeErro(Map<String, String> msg) {
        String message = deliverPage.getAlertError();
        message = message.replace("á", "a");
        assertEquals(msg.get("mensagem"), message);
    }

    @Entao("o endereco deve ser preenchido da seguinte forma")
    public void oEnderecoDeveSerPreenchidoDaSeguinteForma(Map<String, String> map) {
        String address = deliverPage.getAddress();
        String bairro = deliverPage.getBairro();
        String cidade = deliverPage.getCidadeUf();

        assertEquals(map.get("rua"), address);
        assertEquals(map.get("bairro"), bairro);
        assertEquals(map.get("cidadeUf"), cidade);
    }

    @Entao("deve mostrar uma mensagem para cada campo obrigatorio")
    public void deveMostrarUmaMensagemParaCadaCampoObrigatorio(Map<String, String> map) {
        String msg = deliverPage.getAlertField(map.get("campo"));
        msg = msg.replace("É necessário", "E necessario");
        msg = msg.replace("número", "numero");
        msg = msg.replace("endereço", "endereco");
        msg = msg.replace("método", "metodo");

        assertEquals(map.get("mensagem"), msg);
    }
}
