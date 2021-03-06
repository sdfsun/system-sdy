@/*
    名称查询条件标签的参数说明:

    name : 查询条件的名称
    id : 查询内容的input框id
@*/
<div class="input-group">
    <div class="input-group-btn">
        <button data-toggle="dropdown" class="btn btn-white dropdown-toggle"
                type="button">${name}
        </button>
    </div>
    <input class="form-control" id="${id}" placeholder="${placeholder!}"
           @if(isNotEmpty(type)){
           type="${type}"
           @}else{
           type="text"
           @}
           @if(isNotEmpty(pattern)){
           pattern="${pattern}"
           @}
           @if(isNotEmpty(onblur)){
           onblur="${onblur}"
           @}
    />
</div>