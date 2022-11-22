package kr.kwangan2.springbootboard.board.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {

	@Id
	@GeneratedValue
	private Long seq;
	private String title;

	@Column(updatable = true)
	private String writer;
	private String content;
	
	@Column(insertable = false, updatable = true, columnDefinition = "date default sysdate")
	private Date createDate;

	@Column(insertable = false, updatable = true, columnDefinition = "number default 0")
	private Long cnt;

}
