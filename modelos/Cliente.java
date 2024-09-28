package modelos

public class Cliente {
        private int ID;
        private String TIPO_PESSOA;
        private String CPF_CNPJ;
        private String NOME;
        private double LIMITE_CREDITO;

        public Cliente(int ID, String TIPO_PESSOA, String CPF_CNPJ, String NOME, double LIMITE_CREDITO) {
                this.ID = ID;
                this.TIPO_PESSOA = TIPO_PESSOA;
                this.CPF_CNPJ = CPF_CNPJ;
                this.NOME = NOME;
                this.LIMITE_CREDITO = LIMITE_CREDITO;
        }

        public Cliente(String nome, String tipoPessoa, String cpfCnpj, double limiteCredito) {
                this.NOME = nome;
                this.TIPO_PESSOA = tipoPessoa;
                this.CPF_CNPJ = cpfCnpj;
                this.LIMITE_CREDITO = limiteCredito;
        }

        public int getID() {
                return ID;
        }

        public void setID(int ID) {
                this.ID = ID;
        }

        public String getTIPO_PESSOA() {
                return TIPO_PESSOA;
        }

        public void setTIPO_PESSOA(String TIPO_PESSOA) {
                this.TIPO_PESSOA = TIPO_PESSOA;
        }

        public String getCPF_CNPJ() {
                return CPF_CNPJ;
        }

        public void setCPF_CNPJ(String CPF_CNPJ) {
                this.CPF_CNPJ = CPF_CNPJ;
        }

        public String getNOME() {
                return NOME;
        }

        public void setNOME(String NOME) {
                this.NOME = NOME;
        }

        public double getLIMITE_CREDITO() {
                return LIMITE_CREDITO;
        }

        public void setLIMITE_CREDITO(double LIMITE_CREDITO) {
                this.LIMITE_CREDITO = LIMITE_CREDITO;
        }
}
