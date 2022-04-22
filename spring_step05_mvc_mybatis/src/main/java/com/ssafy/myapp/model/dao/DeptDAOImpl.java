package com.ssafy.myapp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.myapp.model.dto.Dept;

@Repository
public class DeptDAOImpl implements DeptDAO {

	private SqlSession sqlSession;
	private static final String NAME_SPACE = "com.ssafy.myapp.model.dao.DeptDAO.";

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public boolean insertDept(Dept dept) {
		return sqlSession.insert(NAME_SPACE + "insertDept", dept) > 0;
	}

	@Override
	public Dept selectDept(int deptNo) {
		return sqlSession.selectOne(NAME_SPACE + "selectDept", deptNo);
	}

	@Override
	public Dept selectDeptWithEmpList(int deptNo) {
		return sqlSession.selectOne(NAME_SPACE + "selectDeptWithEmpList", deptNo);
	}

	@Override
	public List<Dept> selectDeptList() {
		return sqlSession.selectList(NAME_SPACE + "selectDeptList");
	}

	@Override
	public boolean deleteDept(int deptNo) {
		return sqlSession.delete(NAME_SPACE + "deleteDept", deptNo) > 0;
	}

	@Override
	public boolean updateDept(Dept dept) {
		return sqlSession.update(NAME_SPACE + "updateDept", dept) > 0;
	}

	// 부서이름을 이용하여 포함검색한 부서리스트 리턴
	@Override
	public List<Dept> selectDeptListByName(String dName) {
		return sqlSession.selectList(NAME_SPACE + "selectDeptListByName", "%" + dName + "%");
	}

	@Override
	public List<Dept> selectDeptListByCondition(Map<String, String> condition) {
		return sqlSession.selectList(NAME_SPACE + "selectDeptListByCondition", condition);
	}
}
