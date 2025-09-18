---

### **Estrutura das Tabelas**

#### **Tabela `auditoria`**

| Coluna | Tipo | Validações |
| :--- | :--- | :--- |
| `tabela` | `varchar(20)` | `NULL` |
| `acao` | `varchar(20)` | `NULL` |
| `usuario` | `varchar(20)` | `NULL` |
| `data_hora` | `datetime` | `NULL` |
| `chave` | `varchar(5)` | `NULL` |
| `antes` | `varchar(1000)` | `NULL` |
| `depois` | `varchar(1000)` | `NULL` |

---

#### **Tabela `emprestimo`**

| Coluna          | Tipo           | Validações                                               |
|:----------------|:---------------|:---------------------------------------------------------|
| `id`            | `int(5)`       | **PRIMARY KEY**, `NOT NULL`, `AUTO_INCREMENT`            |
| `unidade`       | `int(7)`       | `NOT NULL`, Chave estrangeira para `equipamento.unidade` |
| `tipoequip`     | `int(7)`       | `NOT NULL`, Chave estrangeira para `tipoequipamento.id`  |
| `modelo`        | `varchar(30)`  | `NOT NULL`                                               |
| `destino`       | `int(7)`       | `NOT NULL`, Chave estrangeira para `unidade.id`          |
| `nome`          | `int(7)`       | `NOT NULL`, Chave estrangeira para `nome.id`             |
| `dataSaida`     | `date`         | `NOT NULL`                                               |
| `dataDevolucao` | `date`         | `NOT NULL`                                               |
| `status`        | `varchar(15)`  | `NOT NULL`                                               |
| `tipo`          | `varchar(10)`  | `NOT NULL`                                               |
| `observacao`    | `varchar(250)` | `NOT NULL`                                               |
| `tombo`         | `varchar(10)`  | `NOT NULL`                                               |
| `serie`         | `varchar(30)`  | `NOT NULL`                                               |

---

#### **Tabela `equipamento`**

| Coluna        | Tipo           | Validações                                              |
|:--------------|:---------------|:--------------------------------------------------------|
| `id`          | `int(7)`       | **PRIMARY KEY**, `NOT NULL`, `AUTO_INCREMENT`           |
| `unidade`     | `int(7)`       | `NOT NULL`, Chave estrangeira para `unidade.id`         |
| `tipoequip`   | `int(7)`       | `NOT NULL`, Chave estrangeira para `tipoequipamento.id` |
| `tombo`       | `varchar(10)`  | `UNIQUE`, `NULL`                                        |
| `serie`       | `varchar(30)`  | `UNIQUE`, `NULL`                                        |
| `fornecedor`  | `int(7)`       | `NOT NULL`, Chave estrangeira para `fornecedor.id`      |
| `fabricante`  | `int(7)`       | `NOT NULL`, Chave estrangeira para `fabricante.id`      |
| `modelo`      | `varchar(30)`  | `NOT NULL`                                              |
| `status`      | `varchar(15)`  | `NULL`                                                  |
| `equipamento` | `varchar(30)`  | `NULL`                                                  |
| `observacao`  | `varchar(250)` | `NULL`                                                  |

---

#### **Tabela `fabricante`**

| Coluna           | Tipo          | Validações                                    |
|:-----------------|:--------------|:----------------------------------------------|
| `id`             | `int(7)`      | **PRIMARY KEY**, `NOT NULL`, `AUTO_INCREMENT` |
| `fabricantenome` | `varchar(20)` | `NULL`                                        |

---

#### **Tabela `fornecedor`**

| Coluna           | Tipo          | Validações                                    |
|:-----------------|:--------------|:----------------------------------------------|
| `id`             | `int(7)`      | **PRIMARY KEY**, `NOT NULL`, `AUTO_INCREMENT` |
| `fornecedornome` | `varchar(20)` | `NOT NULL`                                    |

---

#### **Tabela `importpdf`**

| Coluna    | Tipo         | Validações                                    |
|:----------|:-------------|:----------------------------------------------|
| `id`      | `int(7)`     | **PRIMARY KEY**, `NOT NULL`, `AUTO_INCREMENT` |
| `arquivo` | `mediumblob` | `NOT NULL`                                    |
| `tipo`    | `varchar(5)` | `NOT NULL`                                    |

---

#### **Tabela `login`**

| Coluna    | Tipo          | Validações                                    |
|:----------|:--------------|:----------------------------------------------|
| `id`      | `int(6)`      | **PRIMARY KEY**, `NOT NULL`, `AUTO_INCREMENT` |
| `usuario` | `varchar(14)` | `NOT NULL`                                    |
| `nome`    | `varchar(50)` | `NOT NULL`                                    |
| `senha`   | `varchar(20)` | `NOT NULL`                                    |
| `email`   | `varchar(50)` | `NOT NULL`                                    |
| `tipo`    | `varchar(7)`  | `NOT NULL`                                    |
| `data`    | `date`        | `NOT NULL`                                    |

---

#### **Tabela `nome`**

| Coluna       | Tipo          | Validações                                    |
|:-------------|:--------------|:----------------------------------------------|
| `id`         | `int(7)`      | **PRIMARY KEY**, `NOT NULL`, `AUTO_INCREMENT` |
| `nomepessoa` | `varchar(40)` | `NOT NULL`                                    |

---

#### **Tabela `tipoequipamento`**

| Coluna                | Tipo          | Validações                                    |
|:----------------------|:--------------|:----------------------------------------------|
| `id`                  | `int(7)`      | **PRIMARY KEY**, `NOT NULL`, `AUTO_INCREMENT` |
| `tipoequipamentonome` | `varchar(17)` | `NOT NULL`                                    |

---

#### **Tabela `unidade`**

| Coluna        | Tipo          | Validações                                    |
|:--------------|:--------------|:----------------------------------------------|
| `id`          | `int(5)`      | **PRIMARY KEY**, `NOT NULL`, `AUTO_INCREMENT` |
| `unidadenome` | `varchar(10)` | `NOT NULL`                                    |

---

### **Dados das Tabelas**

#### **Dados da Tabela `emprestimo`**

| id | unidade | tipoequip | modelo      | destino | nome | dataSaida  | dataDevolucao | status     | tipo       | observacao | tombo | serie  |
|:---|:--------|:----------|:------------|:--------|:-----|:-----------|:--------------|:-----------|:-----------|:-----------|:------|:-------|
| 1  | 1       | 1         | 22MP55PQ-BK | 1       | 1    | 2022-11-30 | 2022-11-02    | DISPONIVEL | EMPRESTIMO |            | S/T   | 001890 |
| 2  | 1       | 1         | 22MP55PQ-BK | 1       | 1    | 2022-11-30 | 2022-11-18    | DISPONIVEL | EMPRESTIMO |            | S/T   | 001890 |
| 3  | 1       | 1         | 22MP55PQ-BK | 1       | 1    | 2022-11-25 | 2022-11-11    | DISPONIVEL | EMPRESTIMO |            | S/T   | 001890 |

---

#### **Dados da Tabela `equipamento`**

| id | unidade | tipoequip | tombo   | serie  | fornecedor | fabricante | modelo                   | status     | equipamento | observacao                              |
|:---|:--------|:----------|:--------|:-------|:-----------|:-----------|:-------------------------|:-----------|:------------|:----------------------------------------|
| 1  | 1       | 3         | S/T     | 01890  | 1          | 3          | 22MP55PQ-BK-01           | FUNCIONAL  | PATRIMONIO  |                                         |
| 2  | 1       | 1         | 307-816 | 764936 | 3          | 5          | L5000-01                 | FUNCIONAL  | PATRIMONIO  |                                         |
| 3  | 1       | 6         | 356-179 | 00024  | 3          | 6          | LM100B1-02               | FUNCIONAL  | PATRIMONIO  |                                         |
| 4  | 1       | 6         | 42290   | 80068  | 3          | 6          | ML1000B1-01              | FUNCIONAL  | PATRIMONIO  |                                         |
| 5  | 1       | 6         | 356-167 | 00017  | 1          | 6          | ML1000B1-02              | FUNCIONAL  | PATRIMONIO  |                                         |
| 6  | 1       | 3         | 507-835 | 61822  | 3          | 5          | 22HQLED-01               | FUNCIONAL  | PATRIMONIO  |                                         |
| 7  | 1       | 1         | 76495   | S/S    | 3          | 5          | L5000-02                 | FUNCIONAL  | PATRIMONIO  | COMPUTADOR DE ROQUE                     |
| 8  | 1       | 2         | 358-797 | 44970  | 3          | 13         | MFC8712DW-01             | FUNCIONAL  | PATRIMONIO  |                                         |
| 9  | 1       | 9         | 487-760 | 679412 | 3          | 12         | IDEAPAD S1451511L-01     | FUNCIONAL  | PATRIMONIO  |                                         |
| 11 | 1       | 3         | S/T-01  | 51291  | 3          | 7          | 223V5L-01                | FUNCIONAL  | PATRIMONIO  | MONITOR SEM ETIQUETA DE TOMBO           |
| 12 | 1       | 3         | S/T-02  | 54331  | 3          | 7          | 223V5L-02                | FUNCIONAL  | PATRIMONIO  | MONITOR SEM ETIQUETA DE TOMBO           |
| 13 | 1       | 9         | 383-040 | CW0TW  | 3          | 10         | HP OFFICEJET PRO 8610-01 | MANUTENCAO | PATRIMONIO  | IMPRESSORA PRECISA IR PARA A MANUTENCAO |
| 14 | 1       | 3         | 507-831 | 11148  | 3          | 5          | 22HQ-LED-02              | FUNCIONAL  | PATRIMONIO  |                                         |
| 15 | 1       | 3         | 507-834 | 10801  | 3          | 5          | 22HQLED-03               | FUNCIONAL  | PATRIMONIO  |                                         |
| 16 | 1       | 3         | 507-829 | 10919  | 3          | 5          | 22HQLED-04               | FUNCIONAL  | PATRIMONIO  |                                         |
| 17 | 1       | 3         | 507-832 | 119990 | 3          | 5          | 22HQLED-04               | FUNCIONAL  | PATRIMONIO  |                                         |
| 18 | 1       | 3         | 507-833 | 11115  | 3          | 5          | 22HQLED-05               | FUNCIONAL  | PATRIMONIO  |                                         |
| 19 | 1       | 7         | 356-174 | 00010  | 3          | 6          | ML1000B1-03              | FUNCIONAL  | PATRIMONIO  |                                         |
| 20 | 1       | 7         | S/T-03  | 24634  | 3          | 8          | STATION11-01             | MANUTENCAO | PATRIMONIO  |                                         |
| 21 | 1       | 7         | S/T-04  | 24639  | 3          | 8          | STATION11-02             | MANUTENCAO | PATRIMONIO  |                                         |
| 22 | 1       | 3         | S/T-05  | 54333  | 3          | 7          | 223V5L-03                | FUNCIONAL  | PATRIMONIO  | MONITOR SEM PLACA DE TOMBO              |
| 23 | 1       | 3         | 507-827 | 11147  | 3          | 5          | 22HQLED-06               | FUNCIONAL  | PATRIMONIO  |                                         |
| 24 | 1       | 3         | 507-830 | 10804  | 3          | 5          | 22HQLED-07               | FUNCIONAL  | PATRIMONIO  |                                         |
| 26 | 1       | 1         | 507-872 | 76491  | 3          | 5          | L5000-03                 | FUNCIONAL  | PATRIMONIO  |                                         |
| 27 | 1       | 1         | 507-820 | 76489  | 3          | 5          | L5000-04                 | FUNCIONAL  | PATRIMONIO  |                                         |
| 28 | 1       | 1         | 507-818 | 76488  | 3          | 5          | L5000-05                 | FUNCIONAL  | PATRIMONIO  |                                         |
| 29 | 1       | 1         | 307-821 | 76492  | 3          | 5          | L5000-06                 | FUNCIONAL  | PATRIMONIO  |                                         |
| 30 | 1       | 1         | 507-817 | 76490  | 3          | 5          | L5000-07                 | FUNCIONAL  | PATRIMONIO  |                                         |
| 31 | 1       | 1         | 507-819 | 76494  | 3          | 5          | L5000-08                 | FUNCIONAL  | PATRIMONIO  |                                         |
| 32 | 1       | 2         | 404-299 | 01418  | 3          | 9          | POWERLITE S27-01         | FUNCIONAL  | PATRIMONIO  |                                         |
| 33 | 1       | 8         | 453-673 | 02524  | 3          | 14         | L5XL5A-01                | FUNCIONAL  | PATRIMONIO  |                                         |

---

#### **Dados da Tabela `fabricante`**

| id | fabricantenome |
|:---|:---------------|
| 1  | AMD            |
| 2  | COMTECH        |
| 3  | DATEN          |
| 4  | TESTE          |
| 5  | LOGIN          |
| 6  | BMI            |
| 7  | PHILIPS        |
| 8  | SMS            |
| 9  | EPSON          |
| 10 | HP             |
| 11 | ACER           |
| 12 | LENOVO         |
| 13 | BROTHER        |
| 14 | LEXSOM         |

---

#### **Dados da Tabela `fornecedor`**

| id | fornecedornome |
|:---|:---------------|
| 1  | COMTECH        |
| 2  | TESTE          |
| 3  | SEMUR          |

---

#### **Dados da Tabela `login`**

| id | usuario      | nome                  | senha    | email                           | tipo  | data       |
|:---|:-------------|:----------------------|:---------|:--------------------------------|:------|:-----------|
| 1  | marcos       | marcos antonio        | root     | marcosone1998@gmail.com         | Admin | 2022-08-20 |
| 2  | RTDECA       | RUY TADEU DEL REY EÇA | 123456   | TESTE                           | Admin | 2022-08-20 |
| 4  | REY          | REINILSON             | 123456   | TESTE                           | Admin | 2022-08-20 |
| 5  | ROQUE.JUNIOR | ROQUE JUNIOR          | jt080882 | ROQUE.JUNIOR@SALVADOR.BA.GOV.BR | ADMIN | 2022-09-29 |

---

#### **Dados da Tabela `nome`**

| id | nomepessoa       |
|:---|:-----------------|
| 1  | MANOEL DOS ANJOS |
| 2  | ANA LUCIA FARIAS |
| 3  | IVETE SACRAMENTO |
| 4  | ROQUE JUNIOR     |
| 5  | ALISSON SODRÉ    |

---

#### **Dados da Tabela `tipoequipamento`**

| id | tipoequipamentonome |
|:---|:--------------------|
| 1  | COMPUTADOR          |
| 2  | IMPRESSORA          |
| 3  | MONITOR             |
| 4  | CABO HDMI           |
| 5  | TESTE               |
| 6  | ESTABILIZADOR       |
| 7  | NOBREAK             |
| 8  | AMPLIFICADOR        |
| 9  | NOTEBOOK            |

---

#### **Dados da Tabela `unidade`**

| id | unidadenome |
|:---|:------------|
| 1  | NTI         |
| 2  | GAB         |
| 3  | TESTE       |

---
