package org.podxboq.hcv.repositories;

import org.podxboq.hcv.models.Mascota;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class MascotasRepository implements JpaRepository<Mascota, Long> {
	@Override
	public void flush() {

	}

	@Override
	public <S extends Mascota> S saveAndFlush(S entity) {
		return null;
	}

	@Override
	public <S extends Mascota> List<S> saveAllAndFlush(Iterable<S> entities) {
		return List.of();
	}

	@Override
	public void deleteAllInBatch(Iterable<Mascota> entities) {

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> longs) {

	}

	@Override
	public void deleteAllInBatch() {

	}

	@Override
	public Mascota getOne(Long aLong) {
		return null;
	}

	@Override
	public Mascota getById(Long aLong) {
		return null;
	}

	@Override
	public Mascota getReferenceById(Long aLong) {
		return null;
	}

	@Override
	public <S extends Mascota> Optional<S> findOne(Example<S> example) {
		return Optional.empty();
	}

	@Override
	public <S extends Mascota> List<S> findAll(Example<S> example) {
		return List.of();
	}

	@Override
	public <S extends Mascota> List<S> findAll(Example<S> example, Sort sort) {
		return List.of();
	}

	@Override
	public <S extends Mascota> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends Mascota> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends Mascota> boolean exists(Example<S> example) {
		return false;
	}

	@Override
	public <S extends Mascota, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
		return null;
	}

	@Override
	public <S extends Mascota> S save(S entity) {
		return null;
	}

	@Override
	public <S extends Mascota> List<S> saveAll(Iterable<S> entities) {
		return List.of();
	}

	@Override
	public Optional<Mascota> findById(Long aLong) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long aLong) {
		return false;
	}

	@Override
	public List<Mascota> findAll() {
		return List.of();
	}

	@Override
	public List<Mascota> findAllById(Iterable<Long> longs) {
		return List.of();
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Long aLong) {

	}

	@Override
	public void delete(Mascota entity) {

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> longs) {

	}

	@Override
	public void deleteAll(Iterable<? extends Mascota> entities) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public List<Mascota> findAll(Sort sort) {
		return List.of();
	}

	@Override
	public Page<Mascota> findAll(Pageable pageable) {
		return null;
	}
}