import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {

	public static void main(String[] args) {
		// Instanciacao
		
		LocalDate d01 = LocalDate.now();
		System.out.println("d01 = " + d01);
		
		LocalDateTime d02 = LocalDateTime.now();
		System.out.println("d02 = " + d02);
		
		Instant d03 = Instant.now();
		System.out.println("d03 = " + d03);
		
		LocalDate d04 = LocalDate.parse("2023-02-01");
		System.out.println("d04 = " + d04);
		
		LocalDateTime d05 = LocalDateTime.parse("2023-02-01T01:30:26");
		System.out.println("d05 = " + d05);
		
		Instant d06 = Instant.parse("2023-02-01T01:30:26Z");
		System.out.println("d06 = " + d06);
		
		Instant d07 = Instant.parse("2023-02-01T01:30:26-03:00");
		System.out.println("d07 = " + d07);
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d08 = LocalDate.parse("01/02/2023", fmt1);
		System.out.println("d08 = " + d08);
		
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime d09 = LocalDateTime.parse("01/02/2023 01:30", fmt2);
		System.out.println("d09 = " + d09);
		
		LocalDate d10 = LocalDate.of(2022, 7, 20);
		System.out.println("d10 = " + d10);
		
		LocalDateTime d11 = LocalDateTime.of(2022, 7, 20, 1, 30);
		System.out.println("d11 = " + d11);
		
				
		// (agora) -> Data-hora
		// Texto ISO 8601 -> Data-hora
		// Texto formato customizado -> Data-hora
		// dia, mes, ano, [horario] -> Data-hora local
		
		// Formatação
		// Data-hora -> Texto ISO 8601
		// Data-hora -> Texto formato customizado
		
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d12 = LocalDate.parse("2023-02-01");
		System.out.println("d12 = " + d12.format(fmt3));
		System.out.println("d12 = " + fmt3.format(d12));

		DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime d13 = LocalDateTime.parse("2023-02-01T01:30:26");
		System.out.println("d13 = " + d13.format(fmt4));
		System.out.println("d13 = " + fmt4.format(d13));

		DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		Instant d14 = Instant.parse("2023-02-01T01:30:26Z");
		System.out.println("d14 = " + fmt5.format(d14));
		
		Instant d15 = Instant.parse("2023-02-01T01:30:26Z");
		LocalDate r1 = LocalDate.ofInstant(d15, ZoneId.systemDefault());
		System.out.println("R1 (d15) = " + r1);
		
		LocalDate r2 = LocalDate.ofInstant(d15, ZoneId.of("Portugal"));
		System.out.println("R2 (d15) = " + r2);
		
		LocalDateTime r3 = LocalDateTime.ofInstant(d15, ZoneId.systemDefault());
		System.out.println("R3 (d15) = " + r3);
		
		LocalDateTime r4 = LocalDateTime.ofInstant(d15, ZoneId.of("Portugal"));
		System.out.println("R4 (d15) = " + r4);
		
		System.out.println("D13  DIA= " + d13.getDayOfMonth());
		System.out.println("D13  MES= " + d13.getMonthValue());
		System.out.println("D13  ANO= " + d13.getYear());
		System.out.println("D13  HORA= " + d13.getHour());
		System.out.println("D13  MINUTOS= " + d13.getMinute());
		System.out.println("D13  SEGUNDOS= " + d13.getSecond());
		
		// Calculos utilizando data-hora
		
		System.out.println();
		System.out.println("CALCULO COM DATA HORA");
		
		LocalDate d16 = LocalDate.parse("2023-02-01");
				
		LocalDate SemanaAnteriorLocalDate = d16.minusDays(7);
		System.out.println("Menos uma Semana = " + SemanaAnteriorLocalDate);
		LocalDate SemanaSeguinteLocalDate = d16.plusDays(7);
		System.out.println("Mais uma Semana = " + SemanaSeguinteLocalDate);
		LocalDate AnoSeguinteLocalDate = d16.plusYears(7);
		System.out.println("Sete Anos a mais = " + AnoSeguinteLocalDate);
		
		System.out.println();
		System.out.println("Fazendo calculo com data em INSTANT");
		Instant d17 = Instant.parse("2023-02-01T01:30:26Z");
		Instant menosSemana = d17.minus(7, ChronoUnit.DAYS);
		System.out.println("Menos uma Semana = " + menosSemana);
		Instant maisSemana = d17.plus(7, ChronoUnit.DAYS);
		System.out.println("Mais uma Semana = " + maisSemana);

		System.out.println();
		System.out.println("DIFERENCA DE DIAS ENTRE DATAS");
		Duration t1 = Duration.between(SemanaAnteriorLocalDate.atTime(0, 0), d16.atTime(0, 0));
		System.out.println("t1 dias = " + t1.toDays());
		t1 = Duration.between(SemanaAnteriorLocalDate.atStartOfDay(), d16.atStartOfDay());
		System.out.println("t1 dias = " + t1.toDays());
		Duration t2 = Duration.between(maisSemana, d17);		
		System.out.println("t2 dias = " + t2.toDays());


	}

}
